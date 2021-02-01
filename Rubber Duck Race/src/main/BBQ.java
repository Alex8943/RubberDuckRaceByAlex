package main;

import javax.management.relation.RelationNotFoundException;
import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.*;

public class BBQ {

    ArrayList<Queue> listOfQueues = new ArrayList<>();

    public void raceSimolation(int numberOfQueues){
        makeStartUpset(numberOfQueues);
        System.out.println(getList());

        for (int i = 0; i < numberOfQueues; i++) {
            nextTimeStamp();
            System.out.println(getList());
        }
    }

    public void makeStartUpset(int que){
        int numberOfQues = que;
        int counter = 1;

        for (int i = 0; i < numberOfQues; i++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int j = counter; j <counter + numberOfQues; j++){
                queue.add(j);
            }

            counter += numberOfQues;
            listOfQueues.add(queue);
        }
    }


    public void nextTimeStamp(){
        ArrayList<Queue> listOfNewQueus = new ArrayList<>();

        int numberOfQueus = getList().size()-1;
        Random random = new Random();

        for (int i = 0; i < numberOfQueus ; i++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < numberOfQueus; j++) {
                int randomNumber = random.nextInt(getList().size());

                Queue randomQueue = getList().get(randomNumber);
                queue.add((Integer) randomQueue.poll());

                if (getList().get(randomNumber).size() == 0){
                    getList().remove(randomNumber);
                }
            }
            listOfNewQueus.add(queue);
        }
        listOfQueues = listOfNewQueus;
    }

    public ArrayList<Queue> getList(){
        return listOfQueues;
    }
}
