#include <stdlib.h>
#include <stdio.h> 
#include <string.h> 
#include <assert.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h> 
#include <sys/wait.h> 

void fils(int fds[2]){
	close(fds[0]); // fermeture de la lecture 
	
	char *mot = malloc(100 * sizeof(char));
	scanf("%s", mot);
	write(fds[1], mot, strlen(mot));
}

void pere(int fds[2]){
	close(fds[1]); // fermeture de l'écriture

	char c; 
	char *mot = malloc(100 * sizeof(char));
	do{
		read(fds[0], &c, sizeof(char));
		strncat(mot, &c, 1);
	}while(c != '&');
	printf("%s\n", mot); 
}

int main(){	
	int fds[2]; // fds[0] == lecture // fds[1] == ecriture
	int ret = pipe(fds);
	assert(ret != -1);


	if(fork() == 0){
		fils(fds);
	}
	else{
		pere(fds);
		wait(NULL);
	}
	
	// le tube se ferme a la fin de l'execution du programme

	return EXIT_SUCCESS;
}

