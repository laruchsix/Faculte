
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trucher
 */
public class World {
    // attributs  
    private String wname;
    private Map<Robot, Location> robots = new HashMap<>();
    private static List<Location> allloc = new ArrayList<>();
    private List<Location> freeloc = new ArrayList<>();
    
    // constructeur
    public World(String n)
    {
        this.wname = n;
        this.allloc = Location.generate(100, 100);
        this.freeloc = Location.generate(100, 100);
    }
    
    // 
    public static Location pickRandomLocation()
    { 
        int size = allloc.size(); // on stock la taille du monde 
        int poslist = (int) (Math.random() * (size-1)); // prend un nombre aleatoire entre 0 et la taille du monde
        
        return allloc.get(poslist); // renvoie la location de la case correspondant au nbr
    }
    
    public Location locate(Robot r)
    {
        return robots.get("r");
    }
    
    public boolean  hasRobotAtLocation(Location l)
    {
        boolean empty = false; // si la pos n'est pas dans la list freeloc alors elle est deja prise
        for(int i=0; i<freeloc.size();i++ )
        {
            if(freeloc.get(i)==l)
            {   
                empty = true; // la case est libre 
                break; // on a trouver la case -> sorti de la boucle if 
            }
        }
        return empty;
    }
    
    public void killRobot(Robot r)
    {
        freeloc.add(locate(r));
        robots.remove("r");
    }
    
    public void addRobot (String name)
    {
        Location loc = pickRandomLocation();
        Robot r = new Robot(name);
        
        if(hasRobotAtLocation(loc))
        {
            Set<Robot> setRobots = robots.keySet();
            Robot[] tabRobots = (Robot[]) setRobots.toArray();
            for(int i = 0 ; i<tabRobots.length; i++)
            {
                Robot bis = tabRobots[i];
                if(robots.get(bis)==loc)
                {
                    killRobot(bis);
                    break;
                }
            }
        }
        robots.put(r,loc);
    }
    
    public void display()
    {
        Set<Robot> setRobots = robots.keySet();
        Robot[] tabRobots = (Robot[]) setRobots.toArray();
        for(int i = 0 ; i<tabRobots.length; i++)
        {
            Robot bis = tabRobots[i];
            Location loc = robots.get(bis);
            System.out.print("[ " +  bis.toString() +" - ");
            loc.print();
            System.out.print(" ]\n");
        }
        
    }
}
