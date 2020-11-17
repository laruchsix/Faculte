#include <stdlib.h>
#include <assert.h>
#include <unistd.h>  
#include <stdio.h>

int main(int argc, char *argv[]){
	assert(argc >= 3);

	int somme = ((argv[1][0]-48) + (argv[2][0] -48));

	printf("Voici la somme : %d \n", somme);
	return EXIT_SUCCESS;
}
