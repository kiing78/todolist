
import React,{useState} from "react";
import { createItem } from "../services/api";

export default function CreateItemForm(){
    const [taskName,setTaskName]=useState('');

    const handleSubmit = (event) =>{
        event.preventDefault();

        const newItem={taskName};

        createItem(newItem)
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
               <input type="text" value={taskName} onChange={(e) => setTaskName(e.target.value)} />
            </div>
            <button type="submit">Ajouter</button>
        </form>
    );
    
};

