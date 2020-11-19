#directory "rep";;
#load "pointer.cmo";;
open Pointer;;
#show Pointer;;

module type Btree =
  sig
    type 'a t_btree

    val empty : unit -> 'a t_btree
    val rooting : 'a * 'a t_btree * 'a t_btree -> 'a t_btree
      
    val isEmpty : 'a t_btree -> bool
      
    val root : 'a t_btree -> 'a
    val lson : 'a t_btree -> 'a t_btree
    val rson : 'a t_btree -> 'a t_btree
  end

(*module MyBtree : Btree =
  struct
    type 'a t_btree = Empty | Node of 'a * 'a t_btree * 'a t_btree
                                    
    let empty() = Empty
    let rooting(v , fg , fd :  'a * 'a t_btree * 'a t_btree) : 'a t_btree =
      Node (v , fg , fd)

  let isEmpty(abr : 'a t_btree) : bool =
    match abr with
      Empty -> true
    | Node(v,fg,fd) -> false

  let root(abr : 'a t_btree) : 'a =
    match abr with
      Empty -> failwith("un arbre vide n'as pas de valeur")
    | Node(v,fg,fd) -> v
  let lson(abr : 'a t_btree) : 'a t_btree =
    match abr with
      Empty -> failwith("un arbre vide n'as pas de fils gauche")
    | Node(v,fg,fd) -> fg
  let rson(abr : 'a t_btree) : 'a t_btree =
    match abr with
      Empty -> failwith("un arbre vide n'as pas de fils droit")
    | Node(v,fg,fd) -> fd
  end*)
        
module MyBtree : Btree =
  struct
    type 'a node = {
    v : 'a ;
    fg : 'a t_btree ;
    fd : 'a t_btree }
and
'a t_btree = ('a node) ptr
           
    let empty() = null()
    let rooting(v , fg , fd :  'a * 'a t_btree * 'a t_btree) : 'a t_btree =
      alloc( { v = v ; fg = fg ; fd = fd})
                                    

    let isEmpty(abr : 'a t_btree) : bool =
      isNull(abr)

  let root(abr : 'a t_btree) : 'a =
    if isNull(abr)
    then failwith("l'arbre est vide")
    else (!^abr).v
                     
  let lson(abr : 'a t_btree) : 'a t_btree =
    if isNull(abr)
    then failwith("l'arbre est vide")
    else (!^abr).fg
    
  let rson(abr : 'a t_btree) : 'a t_btree =
    if isNull(abr)
    then failwith("l'arbre est vide")
    else (!^abr).fd
  end
