#directory "rep";;
#load "pointer.cmo";;
open Pointer;;
#show Pointer;;

(* ----------------- Exercice 3 : -----------------------*)

(* ---------------------- 1 --------------------- *)

let a = 15;;
let pt_a = alloc(a);;
!^pt_a;;


(* ---------------------- 2  --------------------- *)

type 'a node = {
    mutable v : 'a ;
    fg : 'a t_btree ;
    fd : 'a t_btree }
and
  'a t_btree = ('a node) ptr;;


(* ---------------------- 3 --------------------- *)
