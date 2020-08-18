package com.stage.webservice;

import com.stage.webservice.Action;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {
    private static List<Action> actions = new ArrayList();

    static {

        actions.add(new Action("youssef","rakrouki","1","youssef@esprit.tn","Mariage"));
        actions.add(new Action("admin","admin","07239483","sami@esprit.tn","Divorce"));
    }
    public List<Action> findAll(){
        return actions;
    }
    public Action deleteById(String id){
        Action action = findById(id);

        if (action == null) return null;

       if ( actions.remove(action))
            {return action;}

       return null;
    }

    private Action findById(String id) {
        for(Action action:actions){
            if(action.getId() == id) {
                return action;
            }
        }
        return null;
    }
}
