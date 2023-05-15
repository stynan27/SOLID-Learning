_attribution_: https://opencoursehub.cs.sfu.ca/bfraser/grav-cms/cmpt373/exercises/design_pattern_exercise

# Bakery

A bakery makes two types of cakes: vanilla and chocolate. They now want to make more complex cakes such as a 
"Multi-layered Vanilla cake with sprinkles that says 'Hello World!'"

Change the code so that an order can contain such complex cakes using the 
[Decorator Pattern](https://en.wikipedia.org/wiki/Decorator_pattern):

* Create the necessary decorator classes:
   * For multi-layered cakes, add $5 and print "Multi-layered" out at the front of the name.
   * For sprinkles, add $2 and print "with sprinkles" at the end of the name.
   * For a cake with the saying X, add nothing to the cost, and print "with saying 'X'" at the end of the name.
* Add the new type of cake: strawberry cake, which costs twice as much as a Cake.
* Change the client to add the following to an Order, and print the Order:
   * Chocolate cake
   * Vanilla cake with saying "PLAIN!"
   * Vanilla cake with sprinkles with saying "FANCY"
   * Multi-layered Strawberry cake with double sprinkles and two sayings "One of" and "EVERYTHING"
   * Suggested output is: 

     `Multi-layered Strawberry cake with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING"`

## Constraints
* Adding a new type of cake does not change any existing code (except to instantiate it)
* Adding a new way to decorate or style the cake (such as multi-layer, or with sprinkles) does not change any existing
  code (except to instantiate it)

## Sample output
```text
   10  Chocolate cake
   10  Vanilla cake with saying "PLAIN!"
   12  Vanilla cake with sprinkles with saying "FANCY!"
   29  Multi-layered Strawberry cake with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING"
```