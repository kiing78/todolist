import React, {useEffect,useState} from "react";
import { getItem } from "../services/api";

// Call Get request from API
export default function ListItem(){
    const[tasks,setTasks] = useState([]);
    //  load the element's list
    const [loading, setLoading]=useState(true);
    const [error, setError]=useState(null);

    // Effectue une requete initiale au chargement du composant
    useEffect(()=>{
        getItem()
        .then((response)=>{
            setTasks(response.data);
            setLoading(false);
        })
        .catch((error)=>{
            setError(error);
            console.log("error pas reussi a avoir la donnée", error);
            setLoading(false);
        });

       
    }, []); //l'array vide signifie que l'effet s'execute une seule fois au montage du composant

   

    if (loading) return <p>Loading ...</p>;
    if (error) return <p>Error : {error.message}</p>;

    return(
        <div>
    {Array.isArray(tasks) && tasks.length > 0 ? (
      <ul>
        {tasks.map((task) => (
          <li key={task.taskName}>{task.taskName}</li>
        ))}
      </ul>
    ) : (
      <p>Aucune Tâche</p>
    )}
  </div>
    );
};