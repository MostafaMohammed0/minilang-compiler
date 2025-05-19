package ir;

import java.util.*;

public class MachineCodeGenerator {
    private List<String> assemblyCode;
    private Map<String, Integer> registers;
    private int nextRegister;
    private String format;

    public MachineCodeGenerator() {
        this.assemblyCode = new ArrayList<>();
        this.registers = new HashMap<>();
        this.nextRegister = 0;
        this.format = "nasm"; // Default to NASM format
    }

    public void setFormat(String format) {
        if (format.equals("nasm") || format.equals("gas")) {
            this.format = format;
        } else {
            throw new IllegalArgumentException("Unsupported assembly format: " + format);
        }
    }

    public List<String> generate(List<String> tacCode) {
        assemblyCode.clear();
        registers.clear();
        nextRegister = 0;

        // Add format-specific header
        if (format.equals("nasm")) {
            assemblyCode.add("section .data");
            assemblyCode.add("    format db '%d', 10, 0  ; Format string for printf");
            assemblyCode.add("section .text");
            assemblyCode.add("    global main");
            assemblyCode.add("    extern printf");
            assemblyCode.add("main:");
        } else { // GAS format
            assemblyCode.add(".section .data");
            assemblyCode.add("    format: .string \"%d\\n\"");
            assemblyCode.add(".section .text");
            assemblyCode.add("    .global main");
            assemblyCode.add("main:");
        }

        // Process TAC instructions
        for (String instruction : tacCode) {
            if (instruction.startsWith("PRINT")) {
                generatePrint(instruction);
            } else if (instruction.contains("=")) {
                generateAssignment(instruction);
            } else if (instruction.startsWith("IF")) {
                generateIf(instruction);
            } else if (instruction.startsWith("WHILE")) {
                generateWhile(instruction);
            } else if (instruction.startsWith("LABEL")) {
                generateLabel(instruction);
            } else if (instruction.startsWith("GOTO")) {
                generateGoto(instruction);
            }
        }

        // Add format-specific footer
        if (format.equals("nasm")) {
            assemblyCode.add("    mov eax, 0");
            assemblyCode.add("    ret");
        } else { // GAS format
            assemblyCode.add("    movl $0, %eax");
            assemblyCode.add("    ret");
        }

        return assemblyCode;
    }

    private void generatePrint(String instruction) {
        String[] parts = instruction.split(" ");
        String value = parts[1];
        int reg = getRegister(value);

        if (format.equals("nasm")) {
            assemblyCode.add("    push dword [r" + reg + "]");
            assemblyCode.add("    push dword format");
            assemblyCode.add("    call printf");
            assemblyCode.add("    add esp, 8");
        } else { // GAS format
            assemblyCode.add("    pushl (r" + reg + ")");
            assemblyCode.add("    pushl $format");
            assemblyCode.add("    call printf");
            assemblyCode.add("    addl $8, %esp");
        }
    }

    private void generateAssignment(String instruction) {
        String[] parts = instruction.split(" = ");
        String target = parts[0].trim();
        String value = parts[1].trim();

        int targetReg = getRegister(target);
        int valueReg = getRegister(value);

        if (format.equals("nasm")) {
            assemblyCode.add("    mov eax, [r" + valueReg + "]");
            assemblyCode.add("    mov [r" + targetReg + "], eax");
        } else { // GAS format
            assemblyCode.add("    movl (r" + valueReg + "), %eax");
            assemblyCode.add("    movl %eax, (r" + targetReg + ")");
        }
    }

    private void generateIf(String instruction) {
        String[] parts = instruction.split(" ");
        String condition = parts[1];
        String label = parts[3];

        int reg = getRegister(condition);

        if (format.equals("nasm")) {
            assemblyCode.add("    cmp dword [r" + reg + "], 0");
            assemblyCode.add("    je " + label);
        } else { // GAS format
            assemblyCode.add("    cmpl $0, (r" + reg + ")");
            assemblyCode.add("    je " + label);
        }
    }

    private void generateWhile(String instruction) {
        String[] parts = instruction.split(" ");
        String condition = parts[1];
        String label = parts[3];

        int reg = getRegister(condition);

        if (format.equals("nasm")) {
            assemblyCode.add("    cmp dword [r" + reg + "], 0");
            assemblyCode.add("    je " + label);
        } else { // GAS format
            assemblyCode.add("    cmpl $0, (r" + reg + ")");
            assemblyCode.add("    je " + label);
        }
    }

    private void generateLabel(String instruction) {
        String label = instruction.split(" ")[1];
        assemblyCode.add(label + ":");
    }

    private void generateGoto(String instruction) {
        String label = instruction.split(" ")[1];
        if (format.equals("nasm")) {
            assemblyCode.add("    jmp " + label);
        } else { // GAS format
            assemblyCode.add("    jmp " + label);
        }
    }

    private int getRegister(String value) {
        if (!registers.containsKey(value)) {
            registers.put(value, nextRegister++);
        }
        return registers.get(value);
    }
} 