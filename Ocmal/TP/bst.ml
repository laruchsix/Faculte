#directory "rep";;
(*#use "mybtree.ml";;*)
#load "Btree.cmo";;
#use "fct_aux.ml";;
#use "ap3_def.ml";;
#use "TP_2.ml";;
#load "Ap3queue.cmo";;
open Ap3queue;;
open Btree;;
#show Ap3queue;;
#show Btree;;


(* --------------------- TP 4 ---------------------------- *)

(* --------------------- Exo 1 ---------------------------- *)
(* --------------------- 1 ---------------------------- *)
let rec bst_seek ( a, abr : int * int t_btree) : bool =
  if isEmpty(abr)
  then false
  else
    let (v,fg,fd) : (int * int t_btree * int t_btree) = root(abr) , lson(abr) , rson(abr) in
    if v = a
    then true
    else bst_seek(a, fd) || bst_seek(a, fg)
;;

(* si je trouve le meme nombre dans ce cas je decide de ne pas ajouter la l'entier *)
let rec bst_insert( a, abr : int * int t_btree) : int t_btree =
  if isEmpty(abr)
  then rooting(a, empty(), empty())
  else
    let (v,fg,fd) : (int * int t_btree * int t_btree) = root(abr) , lson(abr) , rson(abr) in
    if a <=v
    then
      if isEmpty(fg)
      then rooting(v, rooting(a, empty(), empty()) , fd)
      else rooting(v, bst_insert(a, g), fd)
    else
      if isEmpty(fd)
      then rooting(v, fg, rooting(a, empty(), empty()))
      else rooting(v, fd, bst_insert(a, fd))
;;

let bst_lbuild ( l : int list ) : int t_btree =
  let abr : int t_btree ref = ref( empty()) in
  let l1 : int list ref = ref l in
  while ( List.length(l) != 0)
  do
    abr := bst_insert(List.hd(!l1), !abr);
    l1 := List.tl(!l1);
  done;
  !abr
;;

let rec bst_delete( v , abr : int * int t_btree) : int t_btree =
  if isEmpty(abr)
  then empty()
  else
     let (value,fg,fd) : (int * int t_btree * int t_btree) = root(abr) , lson(abr) , rson(abr) in
     if v = value
     then
       if (isEmpty(fg) || isEmpty(fd))
          else 
;;
