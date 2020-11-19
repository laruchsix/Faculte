let rec whilellop(r, const, suiv : 'a  * ( 'a -> bool ) * ('a -> 'a)) : 'a =
  if not(cont(r))
  then r
  else whileloop(suiv(r), const, suiv)
;;

let sup( nn, vv : int * int) : bool=
  nn > 0
;;

let next( nn, vv : int * int) : int * int =
  (nn-1 , nn*vv) 
;;

let factiter(n : int) : int =
  let nn : int = 0
  and vv : int = n
  in
 
;;


(* ----------------------- 4 ---------------------------- *)

let factwhile ( n : int ) : int =
  let nn : int ref = ref 1
  and vv : int ref = ref 1
  in
  while !nn > 0
  do
    vv := !nn * !vv;
    nn := !nn - 1;
  done;
  !vv;
  
;;


(* -------------------------- exo 2 --------------------------- *)
(* ---------------------- 1 ---------------------------- *)

(*let rec reverse( li : 'a list) : 'a list =
  (* let rec reverse_aux( l1 , l2 : 'a list * 'a list ) : 'a list =*) 
  if List.length(li) = 0
  then []
  else List.hd::reverse(List.tl(li))
;;
let l1 : int list =[1;2;3];; 
reverse(l1);;
 *)

let rec reverse(l : 'a list) : 'a list=
  match l with
  | [] = []
  | 
;;

let reviter ( l : int list ) : int list =
  let (k, res) : int list * int list = whileloop((l, []) , (function(ll, vv) -> ll <>[]), (function(ll, vv) -> (List.tl(ll), List.hd(ll)::vv)))
  in
  res
;;

let revwhile( l : int list) : int list =
  let ll : int list ref = ref l
  and res : int list ref = ref []
  in
  while ( !ll <> [])
  do
    res := List.hd(!ll)::!res;
    ll := List.tl(!ll);
  done;
  !res
;;

revwhile([1;2;3]);

(* ----------------- eco 3 : ------------------------ *)

type t_nat = Zero | Succ of t_nat;;

let rec add( n , m : t_nat * t_nat) : t_nat=
  match n with
  | Zero -> m
    | Succ(n') -> succ(add(n', m)) 
  ;;
