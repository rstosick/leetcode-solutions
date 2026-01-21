import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

final class Airport {

    private final String name;                  // airport code or name, for example "JFK"
    private final List<FlightLeg> outgoing;     // outgoing legs from this airport

    private static final Comparator<FlightLeg> BY_DESTINATION_NAME =
    new Comparator<FlightLeg>() {
        @Override
        public int compare(FlightLeg a, FlightLeg b) {
            String destNameA = a.getDestination().getName();
            String destNameB = b.getDestination().getName();
            return destNameA.compareTo(destNameB);
        }
    };

    public Airport(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Airport name must not be null or empty");
        }
        this.name = name;
        this.outgoing = new LinkedList<FlightLeg>();
    }

    public String getName() {
        return this.name;
    }

    public void addOutgoing(FlightLeg leg) {
        if (leg == null) {
            throw new IllegalArgumentException("Flight leg must not be null");
        }
        if (leg.getOrigin() != this) {
            throw new IllegalArgumentException("Invalid flight leg origin");
        }
        this.outgoing.add(leg);
    }

    @Override
    public String toString() {
        return "Airport{" + name + "}";
    }

    public void sortOutgoingByDestination() {
        Collections.sort(outgoing, BY_DESTINATION_NAME);
    }

    public FlightLeg popNextLeg() {
        if(outgoing.size()==0) return null;
        else return outgoing.removeFirst();
    }
}


final class FlightLeg {

    private final Airport origin; // origin airport
    private final Airport destination; // destination airport

    public FlightLeg(Airport origin, Airport destination) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("origin and destination must not be null");
        }
        this.origin = origin;
        this.destination = destination;
    }

    public Airport getOrigin() {
        return this.origin;
    }

    public Airport getDestination() {
        return this.destination;
    }
}

final class FlightGraph {

    private final Map<String, Airport> map;
    public FlightGraph() {
        this.map = new HashMap<String, Airport>(); // map name string to Airport object
    }
    public Airport getOrCreateAirport(String name) {
        if(name == null) throw new IllegalArgumentException("Airport name must not be null or empty");
        if(name.isEmpty()) throw new IllegalArgumentException("Airport name must not be null or empty");
        if(this.map.containsKey(name)) {
            return this.map.get(name);
        } else {
            // create the airport
            Airport newAirport = new Airport(name);
            this.map.put(name, newAirport);
            return newAirport;
        }
    }

    public void addLeg(String originString, String destinationString) {
        Airport origin = this.getOrCreateAirport(originString);
        Airport destination = this.getOrCreateAirport(destinationString);
        this.addLeg(origin, destination);
    }

    public void addLeg(Airport origin, Airport destination) {
        if(origin == null) throw new IllegalArgumentException("null origin");
        if(destination == null) throw new IllegalArgumentException("null destination");
        if(!this.map.containsKey(origin.getName())) throw new IllegalArgumentException("airport doesn't exist");
        if(!this.map.containsKey(destination.getName())) throw new IllegalArgumentException("airport doesn't exist");
        FlightLeg newLeg = new FlightLeg(origin, destination);
        origin.addOutgoing(newLeg);
    }
    // convenience lookup that does not create a new Airport
    public Airport getAirport(String name) {
        return this.map.get(name);
    }

    public void sortAllOutgoing() {
        for (Airport airport: map.values()) {
            airport.sortOutgoingByDestination();
        }
    }
}


class Solution {
    private List<String> result; // final itinerary
    private FlightGraph graph;

    private void hierholzer(Airport current) {
        FlightLeg leg = current.popNextLeg();
        while(leg!=null) {
            Airport next = leg.getDestination();
            hierholzer(next);
            leg = current.popNextLeg();
        }
        this.result.add(current.getName());
    }
    
    // Solution entry point
    public List<String> findItinerary(List<List<String>> tickets) {
        this.result = new ArrayList<String>();
        this.graph = new FlightGraph();
        for(List<String> individualTicket: tickets) {
            if(individualTicket.size()!=2) {
                throw new IllegalArgumentException("invalid input");
            } else {
                graph.addLeg(individualTicket.get(0), individualTicket.get(1));
            }
        }
        graph.sortAllOutgoing();

        // Start at JFK
        Airport start = graph.getAirport("JFK");
        if(start==null) throw new IllegalArgumentException("JFK is null!");
        
        // Recursive call
        hierholzer(start);        
        
        // Reverse the List
        Collections.reverse(this.result);
        
        return this.result;
    }
}