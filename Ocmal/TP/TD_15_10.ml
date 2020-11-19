#use "TD_08_10.ml";;

(* ----------------------- Feuille n2 -------------------*)

(* ------------------ Exercice 4 :  -------------------------*)

(* ------------------ 1 -----------------------*)

type t_pile = { value : 'a;
                *head : t_pile;
                *next : t_pile;};;
(* 
Sorte : Stack
Utilise : Element, bool
operations : // constructeurs 
             empty() : -> Stack
             push : Element * Stack -> Stack 
             
             //accesseurs
             top : Stack -> Element
             isEmpty : Stack -> Bool
             pop : Stack -> Stack // depilier 
             
avec : Element , s : Stack
Preconditions : top(s) defini <=> not(empty(s))
                pop(s) defini <=> not(isEmpty(s))
Axioms : pop(push(e, s)) = s 

         top(push(e, s)) = e

         isEmpty(empty()) = true
         isEmpty(push(e, s)) = false

         
 *)

(* ------------------ 2 -----------------------*)

(* ------------------ a -----------------------*)

(* 
Sorte : Operator
Utilise : int 
Operations : // Constructeurs
             Mult : -> Operator
             Div : -> Operator
             Sub : -> Operator
             Add : -> Operator
             
             // accesseurs
             eval : int * int * Operator -> int
Avec : n1, n2 defini <=> int 
Axiomes : eval(n1,n2,Mult) = n1 * n2
          eval(n1,n2,Div) = n1 / n2
          eval(n1,n2,Add) = n1 + n2
          eval(n1,n2,Sub) = n1 - n2
 *)

(* ----------------- b -----------------*)

(* 
Sorte : elem
utilise : Operator , Stack , int 
Operations : //constructeurs
             Const : unit -> elem
             Op : Operator -> elem

             // accesseurs
             eval_exp: elem,  stack -> int 
             eval_exp_aux : elem stack * int stack -> int 
             
avec : exp : elem stack;
       e : element;
       is, is' : int stack ;
       v, v' : int; 
       o : operator; 

preconditions : eval_aux(empty(), is) defini <=> is = push(v,empty())
                eval_aux(push(Oper(o), exp) defini <=> is = push(v,push(v', is'))

axiomes : eval_exp(exp) = eval_aux(exp,empty())
          eval_aux(empty(), push(v,empty())) = v 
          eval_aux(push(const(v), exp), is) = eval_aux(exp, push(v,is))
          eval_aux(push(Op(o), exp), push(v,push(v',is)))
          = eval_aux(exp, push(eval(v,v',o),is))

 *)
type operator = Mult | Add | Sub | Div;;
type elem = Const of int | Op of operator ;;


(* ----------------- feuilles 3 : ----------------- *)

(* --------------- Exercice 1 : -----------------*)

(* 
voir feuille td 
 *)

