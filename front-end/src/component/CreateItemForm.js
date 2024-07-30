
import React,{useState} from "react";
import { createItem } from "../services/api";
import Button from "./Button";


// Add task and call POST request from API
export default function CreateItemForm(){
    const [taskName,setTaskName]=useState('');

    // handleSubmit : recevera une donnée formulaire si le formulaire est envoyé
    const handleSubmit = (event) =>{
        //permet d'éviter de recharger la page lorsque le formulaire est soumis
        event.preventDefault();

        const newItem={taskName};
//      appel de la fonction createItem
        createItem(newItem)
        // promesse que l'objet sera créer avec succes
        .then(response=>{
            console.log("Item created success", response.data);
        })
        .catch(error=>{
            console.log("Error creatinge item", error);
        });
    };
    return (
        <form onSubmit={handleSubmit}>
            <div>
               <input type="text" value={taskName} onChange={(e) => setTaskName(e.target.value)} placeholder="entrer une tache" />
               <Button />
            </div>
            
        </form>
    );
    
};

