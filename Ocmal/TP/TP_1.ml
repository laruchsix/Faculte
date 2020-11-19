let pow2(a : float) : float =
  a *. a
;;

type t_point = { x : float ; y : float };;

let  rotation (p1, theta : t_point * float) : float * float =
    p1.x *. cos(theta) +. p1.y *. sin(theta), -. p1.x *. sin(theta) +. p1.y *. cos(theta )
;;


let p1 : t_point = { x = 1.0 ; y = 0.4};;
rotation(p1,0.2);;


(* Exercice 1 :*)

let norme (a,b,c : float * float * float) : float=
  sqrt((a *. a) +.  (b *. b) +.(c *. c))
;;

norme(1.,1.,1.);;

(* Exercice 2: *)
(*   1   *)
let milieu (p1,p2 : t_point * t_point) : t_point =
  { x = 0.5 *.  (p1.x +. p2.x) ; y = 0.5 *. (p1.y +. p2.y) }
;;

milieu(p1,p1);;

(*   2   *)

let mediatrice (p1 , p2 : t_point * t_point) : float  =
  let midle : t_point = milieu(p1,p2) in 
  
  (2. *. (p2.x -. p1.x) *.  midle.x) +. (2. *. (p2.y -. p1.y) *. midle.y) +.  ((p1.x +. p2.x) *. (p1.x -. p2.x)) +. ((p1.y +. p2.y) *. (p1.y -. p2.y)) 
;;

(* exercice 3 : *)

(*   1   *)

let signe ( a : int ) : string =
  if (a == 0)
  then "nul"
  else if (a < 0)
       then "negatif"
       else "positif"
;;

signe(-1);;
signe(0);;
signe(5);;

(*   2   *) 

let max2 ( a , b : int * int ) : int = 
  if a < b
  then b
  else a
;;

let min2 ( a , b : int * int ) : int =
  if a<b
  then a
  else b
;;


(*    3    *)

let max3 ( a , b , c : int * int * int) : int =
  max2(max2(a,b),c)
;;

let min3 ( a , b , c : int * int * int) : int =
  min2(min2(a,b),c)
;;

(* exercice 4 : *)

let pythagore ( a , b : float * float ) : float =
  sqrt( (a *. a) +. (b *. b))
;;

let longueur ( p1 , p2 : t_point * t_point ) : float =
  let ab : float = pythagore((p2.x -. p1.x),(p2.y -. p1.y)) in
  ab
;;

(* exercice 5 : *)

(*     1    *) 

let  rec qui_suis_je (n : int) : int =
  if n = 0
  then 0
  else n + (qui_suis_je (n-1))
;;

(* somme des entier de n a 0 *)

(*     2    *)

let rec somme_carre (n : int) : int =
  if n <= 0
  then 0
  else (n*n) + somme_carre(n-1) 
;;

(* exercice 6 : *)

(*    1    *) 

let rec heron (x , n : int * int) : float =
  if n=0
  then 1.
  else let a : float =  heron(x, n-1) in 
    0.5 *. ( a +. (float_of_int(x) /. a))
;;

(* heron(5, 100000);; *)


