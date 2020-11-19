#directory "rep";;
#use "mybtree.ml";;
#use "fct_aux.ml";;
#use "ap3_def.ml";;
#load "Ap3queue.cmo";;
open Ap3queue;;
open MyBtree;;
#show Ap3queue;;
#show Btree;;

(* ------------- Exercice 1 :-------------- *)

(* ------------- 1 -------------- *)

let a1 : int t_btree = rooting(1, empty(), empty());; (*longeur de 1*)
let a2 : int t_btree = rooting(2, empty(), empty());; (* longueur de 1 *)
let a3 : int t_btree = rooting(3, a2, a1);; (* longueur de 3*)
let a4 : int t_btree = rooting(4, a3, empty());; (* longueur de 4*)
let a5 : int t_btree = rooting(5, empty(), a4);; (* longueur de 5 *)
let a6 : int t_btree = rooting(6, empty() , empty());; (* longeur de 1*)
let a10 : int t_btree = rooting(5, a4, empty());; (* longueur de 5*)


let a7 : int t_btree = rooting(7, a5, a6);; (* longueur de 7*)
let a8 : int t_btree = rooting(7, a6, a5);; (* longueur de 7 *)
let a9 : int t_btree = rooting(7, a10, a6);;  (* longueur de 7 *)

let b1 : int t_btree = rooting(1, empty(), empty());;
let b2 : int t_btree = rooting(2, empty(), empty());;
let b3 : int t_btree = rooting(3, b2, b1);;
let b4 : int t_btree = rooting(4, empty(), empty());;
let b5 : int t_btree = rooting(5, empty(), empty());;
let b6 : int t_btree = rooting(6, b5, b4);;
let b7 : int t_btree = rooting(7, b6, b3);;

(*
show_int_btree(a7);;
show_int_btree(a8);;
show_int_btree(a9);;
 *)

(* ------------- 2 -------------- *)

let rec size( abr : 'a t_btree) : int =
  if abr = empty()
  then 0 
  else let lenfg : int = size(lson(abr))
         and lenfd : int = size(rson(abr)) in
       1 + lenfg + lenfd
;;

size(a7);;
size(a8);;
size(a9);;


(* ------------- 3 -------------- *)

let rec height ( abr : 'a t_btree) : int =
  if abr = empty()
  then -1
  else  let heightfg : int = height(lson(abr))
         and heightfd : int = height(rson(abr)) in
       1 + max2(heightfg, heightfd)

;;

height(a7);;
height(a8);;
height(a9);;

(* ------------- 4 -------------- *)
let rec size_at_height( abr , height : 'a t_btree * int  ) : int =
  if abr = empty()
  then 0
  else if height = 0 
  then 1
  else let fg : int = size_at_height(lson(abr), height-1)
         and fd : int = size_at_height(rson(abr), height-1) in
           0 + fg + fd
;;

size_at_height(a7, 1);;

(* ------------- 5 -------------- *)

let rec nb_roots( abr : 'a t_btree) : int =
  if abr = empty()
  then 0
  else
    let (fg, fd) : 'a t_btree * 'a t_btree = lson(abr) , rson(abr) in
    if isEmpty(fg) && isEmpty(fd) 
    then 0
    else 1 + nb_roots(fg) + nb_roots(fd)
;;

nb_roots(a7);;
nb_roots(a8);;
nb_roots(a9);;

(* ------------- 6 -------------- *)

let rec nb_leafs( abr : 'a t_btree) : int =
  if abr = empty()
  then 0
  else
    let (fg, fd) : 'a t_btree * 'a t_btree = lson(abr) , rson(abr) in
    if isEmpty(fg) &&  isEmpty(fd) 
    then 1
    else  0 + nb_leafs(fg) + nb_leafs(fd)
;;

nb_leafs(a7);;
nb_leafs(a8);;
nb_leafs(a9);;

(* ------------- Exercice 2 : -------------- *)

(* ------------- 1 -------------- *)

let rec left_border( abr : 'a t_btree ) : 'a list =
  if isEmpty(abr)
  then []
  else concat([root(abr)],left_border(lson(abr)))
;;

left_border(a7);;
left_border(a8);;
left_border(a9);;

(* ------------- 2 -------------- *)
let rec to_list_prefix( abr : 'a t_btree) : 'a list =
  if isEmpty(abr)
  then []
  else let (v,fg,fd) : ('a * 'a t_btree * 'a t_btree) = root(abr) , lson(abr) , rson(abr) in
       let l : 'a list =  concat(to_list_prefix(fg),to_list_prefix(fd)) in 
       concat([v],l)
;;

let rec to_list_infix( abr : 'a t_btree) : 'a list =
  if isEmpty(abr)
  then []
  else let (v,fg,fd) : ('a * 'a t_btree * 'a t_btree) = root(abr) , lson(abr) , rson(abr) in
       concat(to_list_infix(fg), concat([v],to_list_infix(fd)))
;;

let rec to_list_postfix( abr : 'a t_btree) : 'a list =
  if isEmpty(abr)
  then []
  else let (v,fg,fd) : ('a * 'a t_btree * 'a t_btree) = root(abr) , lson(abr) , rson(abr) in
       concat(to_list_postfix(fg), concat(to_list_postfix(fd),[v]))
;;

to_list_prefix(a7);;
to_list_infix(a7);;
to_list_postfix(a7);;
(*show_int_btree(a7);;*)

(* ---------------  Exercice 3: -------------------*)

(* ---------------- 1 -------------*)
(*show_int_btree(a8);; *)
(* [ 7 ; 6 ; 5 ; 4 ; 3 ; 2 ; 1 ] *)

(* show_int_btree(b7);; *)
(* [ 7 ; 6 ; 3 ; 5 ; 4 ; 2 ; 1 ] *)

(* ---------------  2 ----------------*)

(* --------------- 3 -------------------*)
let rec largeur_aux ( queue : 'a t_btree t_queue ) : 'a list =
  if Ap3queue.isEmpty(queue)
  then []
  else let abr : 'a t_btree = qhd(queue) in
       if isEmpty(abr)
       then largeur_aux(qrest(queue))
       else let queue = enter(lson(abr), queue) in
            let queue = enter(rson(abr), queue) in

         concat([root(abr)],largeur_aux(qrest(queue)))
;;

let largeur ( abr : 'a t_btree ) : 'a list =
  largeur_aux( enter(abr, Ap3queue.empty()))
;;

largeur(a9);;
(*show_int_btree(a9);;*)

largeur(b7);;
(*show_int_btree(b7);;*)

(* ------------------ Exercice 4 : -------------------- *)

(* ----------------- 1 ----------------------*)

let c1 : char t_btree = rooting('9' , MyBtree.empty(), MyBtree.empty());;
let c2 : char t_btree = rooting('5' , MyBtree.empty(), MyBtree.empty());;
let c3 : char t_btree = rooting('+' , c1 , c2);;
let c4 : char t_btree = rooting('*' , c1 , c2);;
let c6 : char t_btree = rooting('4' , MyBtree.empty(), MyBtree.empty());;
let c5 : char t_btree = rooting('/' ,c4, c6);;

let c1c : char t_btree = rooting('+' , c5, c4);;
let c2c : char t_btree = rooting('*' , c1c, c3);;
let c3c : char t_btree = rooting('+' , c2c, c6);;

#show Btree;;

(* --------------------------  2 -------------------*)

type oper = Mult| Add | Sub | Div;;
type nobelbl = Oper of oper|Const of int|Var of char ;; 

let ac1 : nobelbl t_btree = rooting(Const 9 , MyBtree.empty(), MyBtree.empty());;
let ac2 : nobelbl t_btree = rooting(Const 5 , MyBtree.empty(), MyBtree.empty());;
let ac3 : nobelbl t_btree = rooting(Oper Add , ac1 , ac2);;
let ac4 : nobelbl t_btree = rooting(Oper Mult , ac1 , ac2);;
let ac6 : nobelbl t_btree = rooting(Const 4 , MyBtree.empty(), MyBtree.empty());;
let ac5 : nobelbl t_btree = rooting(Oper Div ,ac4, ac6);;
let ac7 : nobelbl t_btree = rooting(Oper Div ,MyBtree.empty(), MyBtree.empty());;


let ac1c : nobelbl t_btree = rooting(Oper Add , ac5, ac4);;
let ac2c : nobelbl t_btree = rooting(Oper Mult , ac1c, ac3);;
let ac3c : nobelbl t_btree = rooting(Oper Add , ac2c, ac6);;
let ac4c : nobelbl t_btree = rooting(Const 5 , ac2c, ac6);;
let ac5c : nobelbl t_btree = rooting(Oper Add , ac2c, ac7);;

(* ------------ 3 ----------*)

let string_of_nobelbl(v : nobelbl) : string =
  match v with
    Const(x) -> string_of_int(x)
  | Var(c) -> string_of_int(int_of_char(c))
  | Oper(o) -> match o with
                 Mult -> "*"
               | Add -> "+"
               | Sub -> "-"
               | Div -> "/"
;;




let rec string_btree_of_nobel_btree (abr : nobelbl t_btree) : string t_btree=
  if isEmpty(abr)
  then empty()
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
       let fg : string t_btree = string_btree_of_nobel_btree(fg)
       and fd : string t_btree = string_btree_of_nobel_btree(fd) in
       rooting(string_of_nobelbl(v), fg , fd); 
;;
#show Btree;;
(*show_string_btree(string_btree_of_nobel_btree(ac1c));;
show_string_btree(string_btree_of_nobel_btree(ac2c));;
show_string_btree(string_btree_of_nobel_btree(ac3c));;
show_string_btree(string_btree_of_nobel_btree(ac4c));;
show_string_btree(string_btree_of_nobel_btree(ac5c));;*)
(* -------------------- 4 -------------------*)

let isNode ( abr : 'a t_btree) : bool =
  let (fg , fd) : 'a t_btree * 'a t_btree = MyBtree.lson(abr) , MyBtree.rson(abr) in
  (not(isEmpty(fg)) ||  not(isEmpty(fd)))
;;


let rec well_formed ( abr : nobelbl t_btree) : bool =
  if isEmpty(abr)
  then true
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
    if isNode(abr)
    then match v with
           Const(c) -> false
         | Var(va) -> false 
         | Oper(op) -> ( well_formed(fg) && well_formed(fd))
    else
      match v with
           Const(c) -> true
         | Var(va) -> true
         | Oper(op) -> false
;;

well_formed(ac1c);;
well_formed(ac2c);;
well_formed(ac3c);;
well_formed(ac4c);;
well_formed(ac5c);;

(* --------------- 5 -------------------- *)

let rec string_of_exp_aux ( abr : nobelbl t_btree ) : string =
  if isEmpty(abr)
  then ""
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
       if isNode(abr)
       then "(" ^ string_of_exp_aux(fg) ^ string_of_nobelbl(v) ^ string_of_exp_aux(fd) ^ ")"
       else string_of_nobelbl(v)
;;

let string_of_exp ( abr : nobelbl t_btree ) : string =
  if well_formed(abr)
  then string_of_exp_aux(abr)
  else "erreur"
;;

string_of_exp(ac1c);;
string_of_exp(ac2c);;
string_of_exp(ac3c);;
string_of_exp(ac4c);;
string_of_exp(ac5c);;


(* ---------------- 6 ----------------- *)



let rec derive ( abr : nobelbl t_btree ) : nobelbl t_btree =
  if isEmpty(abr)
  then empty()
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
       match v with
    Const(x) -> rooting(Const 0, empty(), empty())
  | Var(c) -> rooting(Const 1, empty(), empty())
  | Oper(o) -> match o with
                 Mult -> let fg2 : nobelbl t_btree = rooting(Oper Mult, derive(fg), fd)
                         and fd2 : nobelbl t_btree = rooting(Oper Mult, fg , derive(fd)) in
                         rooting(Oper Add, fg2 , fd2)
               | Add -> rooting(Oper Add, derive(fd), derive(fg))
               | Sub -> rooting(Oper Sub, derive(fd), derive(fg))
               | Div -> let finald : nobelbl t_btree = rooting(Oper Mult, fd, fd)
                        and fg2 : nobelbl t_btree = rooting(Oper Mult, derive(fg) , fd)
                        and fd2 : nobelbl t_btree = rooting(Oper Mult, fg, derive(fd)) in
                        let finalg : nobelbl t_btree = rooting(Oper Sub, fg2 , fd2 ) in
                        rooting(Oper Div, finalg , finald)
                                                     
;;

(*show_string_btree(string_btree_of_nobel_btree(ac1c));;
show_string_btree(string_btree_of_nobel_btree(derive(ac1c)));;

show_string_btree(string_btree_of_nobel_btree(ac2c));;
show_string_btree(string_btree_of_nobel_btree(derive(ac2c)));;

show_string_btree(string_btree_of_nobel_btree(ac3c));;
show_string_btree(string_btree_of_nobel_btree(derive(ac3c)));;

show_string_btree(string_btree_of_nobel_btree(ac4c));;
show_string_btree(string_btree_of_nobel_btree(derive(ac4c)));;

show_string_btree(string_btree_of_nobel_btree(ac5c));;
show_string_btree(string_btree_of_nobel_btree(derive(ac5c)));;
 *)

(* ------------- 7 ----------- *)
type couple = { x : nobelbl ;
                v : nobelbl };;


let rec valassoc ( v , l : nobelbl * couple list ) : nobelbl =
  if l = []
  then Const 5
  else
    if ( (List.hd(l)).x = v)
    then (List.hd(l)).v
    else valassoc(v, List.tl(l))
;;

let constantes : couple list = [{ x = Var 'a' ; v = Const 1} ;
                                { x = Var 'b' ; v = Const 2} ;
                                { x = Var 'c' ; v = Const 3} ;
                                { x = Var 'd' ; v = Const 4} ;
                                { x = Var 'e' ; v = Const 5} ;
                                { x = Var 'f' ; v = Const 6} ;
                                { x = Var 'g' ; v = Const 7} ;
                                { x = Var 'h' ; v = Const 8} ;
                                { x = Var 'i' ; v = Const 9} ;
                                { x = Var 'j' ; v = Const 10} ;
                                { x = Var 'k' ; v = Const 11} ;
                                { x = Var 'l' ; v = Const 12} ;
                                { x = Var 'm' ; v = Const 13} ;
                                { x = Var 'n' ; v = Const 14} ;
                                { x = Var 'o' ; v = Const 15} ;
                                { x = Var 'p' ; v = Const 16} ;
                                { x = Var 'q' ; v = Const 17} ;
                                { x = Var 'r' ; v = Const 18} ;
                                { x = Var 's' ; v = Const 19} ;
                                { x = Var 't' ; v = Const 20} ;
                                { x = Var 'u' ; v = Const 21} ;
                                { x = Var 'v' ; v = Const 22} ;
                                { x = Var 'w' ; v = Const 23} ;
                                { x = Var 'x' ; v = Const 24} ;
                                { x = Var 'y' ; v = Const 25} ;
                                { x = Var 'z' ; v = Const 26}];;

let rec eval_aux( abr : nobelbl t_btree ) : int =
  if isEmpty(abr)
  then 0
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
       match v with
         Const(x) -> x
       | Var(vr) -> failwith(" il y a un charatère")
       | Oper(o) -> match o with
                      Mult -> eval_aux(fg) * eval_aux(fd)
                    | Add ->  eval_aux(fg) + eval_aux(fd)
                    | Sub ->  eval_aux(fg) - eval_aux(fd)
                    | Div ->  int_of_float(
                                             float_of_int(eval_aux(fg)) /.
                                             float_of_int(eval_aux(fd))
                                           )
;;

let rec change_var ( abr , l : nobelbl t_btree * couple list ) : nobelbl t_btree =
  if isEmpty(abr)
  then empty()
  else let (v , fg , fd) : nobelbl * nobelbl t_btree * nobelbl t_btree = root(abr), lson(abr), rson(abr) in
       match v with
         Const(x) ->  rooting(v, change_var(fg, l), change_var(fd, l))
       | Var(c) -> rooting(valassoc(v , l), change_var(fg, l), change_var(fd, l))
       | Oper(o) -> rooting(v, change_var(fg, l), change_var(fd, l))
;;

let eval ( abr : nobelbl t_btree ) : int =
  let abr = change_var( abr , constantes ) in 
  if (well_formed(abr))
  then eval_aux(abr)
  else failwith("arbre non conforme ")
;;


eval(ac1c);;
eval(ac2c);;
eval(ac3c);;
eval(ac4c);;
