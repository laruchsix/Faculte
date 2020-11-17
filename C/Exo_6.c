#include <stdlib.h>
#include <stdio.h> 
#include <string.h> 
#include <assert.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h> 
#include <sys/wait.h> 


// le fils écrit sur le 1 et lit sur le 2
void fils(int fds1[2], int fds2[2]){
	close(fds1[0]); // fermeture de la lecture 
	close(fds2[1]); // fermeture de l'écriture
	
	int user[2];
	
	// lecture des entiers 
	read(fds2[0], &user[0], sizeof(int));
	read(fds2[0], &user[1], sizeof(int));
	
	// opération
	int somme = (user[0] + user[1]);
	
	// ecriture de la somme dans le pipe
	write(fds1[1], &somme, sizeof(int)); 
	
	// on ferme les dernier entrées et sorties du pipe
	close(fds1[1]);
	close(fds2[0]);
}

// le pere lit sur le 1 et ecrit sur le 2
void pere(int fds1[2], int fds2[2]){
	close(fds1[1]); // fermeture de l'écriture
	close(fds2[0]); // fermeture de la lecture 
	
	int user[2];
	
	// scan des entier dans le tableau user  
	for(int i = 1; i<= 2; i++){
		printf("Entrer l'entier n°%d :", i);
		scanf("%d", &user[(i-1)]);
	}
	
	// ecriture des entier dans le pipe	
	write(fds2[1], &user[0], sizeof(int));
	write(fds2[1], &user[1], sizeof(int));
	
	int somme;
	// lecture de la somme et affichage 
	read(fds1[0], &somme, sizeof(int));
	printf("voici la somme : %d \n", somme); 
	
	// on ferme les dernier entrées et sorties du pipe
	close(fds1[0]);
	close(fds2[1]);
}

int main(){	
	int fds1[2]; // fds[0] == lecture // fds[1] == ecriture
	int ret1 = pipe(fds1);
	assert(ret1 != -1);
	
	int fds2[2];// fds[0] == lecture // fds[1] == ecriture
	int ret2 = pipe(fds2);	
	assert(ret2 != -1);

	if(fork() == 0){
		// appel du fils
		fils(fds1, fds2);
		
		// on attend l'executions de tous les procesus executer dans le fichier
		wait(NULL);
	}
	else{
		// appel du père 
		pere(fds1, fds2);
		
		// on attend l'executions de tous les procesus executer dans le fichier
		wait(NULL);
	}
	
	// le tube se ferme a la fin de l'execution du programme

	return EXIT_SUCCESS;
}

