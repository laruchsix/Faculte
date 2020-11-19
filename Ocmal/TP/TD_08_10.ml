#directory "rep";;
#load "btree.cmo";;
open Btree;;
#load "gtree.cmo";;
open Gtree;;
#use "TP_2.ml";;
#show Btree;;
#show Gtree;;

let rec fo_of_ab(bt : 'a t_btree) : 'a t_forest =
  if bt = Btree.empty()
  then f_empty()
  else let (v,fg , fd) : 'a * 'a t_btree * 'a t_btree = Btree.root(bt), Btree.lson(bt), Btree.rson(bt) in
       let sons : 'a t_forest = fo_of_ab(fg)
       and brothers : 'a t_forest = fo_of_ab(fd) in
       insert(rooting(v,sons), brothers)
;;

let abrg : int t_gtree = Gtree.rooting(5, fo_of_ab(a7));;
show_int_btree(a7);;
show_int_gtree(abrg);;


(* 
---------------- Exercicie 1 : feuille TD 2 ------------------

Sorte : Day
utilise : bool 
operations : Lundi : -> Day 
             Mardi : -> Day 
             Mercredi : -> Day 
             Jeudi : -> Day 
             Vendredi : -> Day 
             Samedi : -> Day
             Dimanche : -> Day
             is_working_day : Day -> bool
             next_wd : Day -> Day
avec : 
preconditions : non
aximores : is_working_day(lundi()) = true
           is_working_day(mardi()) = true
           is_working_day(mercredi()) = true
           is_working_day(jeudi()) = true
           is_working_day(vendredi()) = true
           is_working_day(samedi()) = false
           is_working_day(dimanche()) = false

           next_wd=(lundi()) = mardi
           next_wd=(mardi()) = mercredi
           next_wd=(mercredi()) = jeudi
           next_wd=(jeudi()) = vendredi
           next_wd=(vendredi()) = lundi
           next_wd=(samedi()) = lundi
           next_wd=(dimanche()) = lundi

 *)

(*
--------------------- Exercice 2 : feuille TD 2 ----------------------


Sorte : Nat
Utilise : bool
Operations : Zero : -> Nat
             Succ : Nat -> Nat
             _+_ : Nat * Nat -> Nat 
             _*_ : Nat * Nat -> Nat 
             _<_ : Nat * Nat -> bool 
             _-_ : Nat * Nat -> Nat 
Avec : n1, n2 : Nat 
Preconditions : n1 - n2 defini <=> n1 >= n2  
Axiomes : n1 + Zero() = n1
          n1 + Succ(n2) = Succ(n1) + n2 

Succ(Succ(Zero())) + Succ(Succ(Zero())) = 
Succ(Succ(Succ(Zero()))) + Succ(Zero()) = 
Succ(Succ(Succ(Succ(Zero())))) + Zero()

          n1 * Zero() = Zero() 
          n1 * Succ(Zero()) = n1
          n1 * Succ(Succ(n2)) = n1 + (n1 * Succ(n2))
          
          n1 < Zero() = false 
          Zero() < Succ(n2) = true
          n2 < Succ(Succ(n2)) = n1 < n2 
          
          n1 - Zero() = n1 
          Succ(n1) - Succ(n2) = n1 - n2
          
          
 *)
