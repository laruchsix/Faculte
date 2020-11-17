#include <stdlib.h>
#include <assert.h>
#include <unistd.h>  
#include <stdio.h>

int main(int argc, char *argv[]){
	//assert(argc >= 3);
	int tab[2];
	for(int i = 1; i<= 2; i++){
		printf("Entrer l'entier n°%d :", i);
		scanf("%d", &tab[(i-1)]);
		
	}

	

	printf("Voici la somme : %d \n", somme);
	return EXIT_SUCCESS;
}
