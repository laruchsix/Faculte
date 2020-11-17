#include <stdlib.h>
#include <stdio.h> 
#include <string.h> 
#include <assert.h>
#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h> 


int main(){
	char * nameFile = "montube";
	int ret = mkfifo(nameFile, 0600); // creation du tube
	assert(ret != -1); 	// test du renvoie systeme

	int fd = open(nameFile, O_WRONLY); // ouverture du tube en mode ecriture
	assert(fd != -1); // test du renvoie systeme

	printf("Le tube viens d'être ouvert en écriture\n");
	
	char lecture = '0';
	while(lecture != '&'){
		scanf("%c", &lecture);
		write(fd, &lecture, sizeof(char));
	}
	
	close(fd); // fermeture du tube

	return EXIT_SUCCESS;
}


