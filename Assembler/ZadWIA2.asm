org 100h

;wczytanie stringa
mov ah,0Ah
mov dx,string
int 21h

;podzielic stringa na 2
mov ah ,00h
mov bx,[string+1]
mov ah,00h
mov cx,02h
mov al,bl;dlugość
div cl;przez to dzielimy
mov bp,string+2
add bp,ax
mov byte [bp],"$"

mov dl,0ah
mov ah,02h
int 21h
mov dl,0dh
int 21h

;Wyswietlenie stringa
mov dx,string+2
mov ah,09h
int 21h
;zakończenie programu
mov ah, 4ch
int 21h

string db 0xff