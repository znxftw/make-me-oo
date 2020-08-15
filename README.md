So Shivam had just learned about OOP. He had written a program before that did two things,
- Find distance between two points
- Find direction (angle) between two points in Radians.

He has this code in the `org.procedural.DistanceAndDirectionCalculator` It looks like this for the reference - 

```java
public class DistanceAndDirectionCalculator {
    public static double distance(double x1, double y1, double x2, double y2) {
        double xDistance = x1 - x2;
        double yDistance = y1 - y2;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static double direction(double x1, double y1, double x2, double y2) {
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        return Math.atan2(yDistance, xDistance);
    }
}
```
He thought it'll be a good idea to convert this to Object Oriented Programming. So he wrote a new implementation in package `org.oop`, he got 2 classes - 
- `org.oop.DistanceAndDirectionCalculator`
- `org.oop.Point`

However, his trainer told him that what he did is not Object Oriented programming and asked Shivam to try again. 
- Try to articulate problems with Shivam's OOP solution. (Write it somewhere and share it with your trainer)
- Fork the project and fix the design related problem with Shivam's OOP solution. Share that with your trainer too.


---


#### Articulation
- The fact that some data and some behaviours which interact with that data are in two different classes means there is little to no encapsulation happening here.
- Hence, lets try to encapsulate the behaviours from DistanceAndDirectionCalculator class with the data from Point Class.
- Here, the getters and setters are merely acting as data modifiers and not really behaviours of the 'Point', hence it isn't really object oriented.
- Also, for the point of this exercise, we only want to know distance and direction, so having getX and getY as public functions ruins the concept of data hiding here.
    - The only public functions of the point class should be distance() and direction().


- As far as I can think of, there are two ways of implementing this. 
    - One is by directly ditto-ing the functions that were originally there in DistanceAndDirectionCalculator and just accessing the variables privately through the class.
    - The above method doesn't really make sense. Why would each Point need to know the distance for any two arbitrary points?
    - Instead let us model the functions as taking a single parameter, which is the destination point. Each point need only calculate the distance from itself to any other point.

#### Changes made
- Added distance and direction to Point class
- distance(p) is the distance from the source point to the point 'p'
- direction(p) is the direction of the source point w.r.t. the point 'p'
- Updated tests accordingly

#### Learnings 
- Initially, I thought this wouldn't work and it would still require getters to access the destination object's private variables.
- When I tried coding it, I found out that access modifiers are not really object-level, they are class-level. 