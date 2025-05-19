section .text
global _start
_start:
mov eax, r0
add eax, '0'
push eax
mov eax, 4
mov ebx, 1
mov ecx, esp
mov edx, 1
int 0x80
add esp, 4
mov eax, r1
add eax, '0'
push eax
mov eax, 4
mov ebx, 1
mov ecx, esp
mov edx, 1
int 0x80
add esp, 4
cmp r2, 0
je L0
mov eax, r0
add eax, '0'
push eax
mov eax, 4
mov ebx, 1
mov ecx, esp
mov edx, 1
int 0x80
add esp, 4
jmp L1
L0:
mov eax, r1
add eax, '0'
push eax
mov eax, 4
mov ebx, 1
mov ecx, esp
mov edx, 1
int 0x80
add esp, 4
L1:
L2:
cmp r3, 0
je L3
mov eax, r0
add eax, '0'
push eax
mov eax, 4
mov ebx, 1
mov ecx, esp
mov edx, 1
int 0x80
add esp, 4
jmp L2
L3:
mov eax, 1
xor ebx, ebx
int 0x80
