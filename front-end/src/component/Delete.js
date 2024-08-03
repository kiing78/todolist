import React, { useEffect, useState } from "react";
import { getItem, deleteItem } from "../services/api";
import List from "./List";

export default function Delete() {
    const [taskList, setTaskList] = useState([]);
    const [message, setMessage] = useState("");
    const [error, setError] = useState("");

    
    useEffect(() => {
        // récupère la liste des tâches
        getItem() 
            .then((response) => {
                // la liste de taches dans setTaskList
                setTaskList(response.data); 
                console.log("les autres données ", response.data);
            })
            .catch((error) => {
                console.log("error pas reussi a avoir la donnée", error);
            });
    }, []);

    const handleDelete = (idTask) => {
        const confirmDelete = window.confirm(`Etes vous sûr de vouloir supprimer la tâche ${idTask}?`);
        if (confirmDelete) {
            deleteItem(idTask)// supprime une tache de la liste
                .then(response => {
    // filter : retourne tous les éléments du tableau de tache qui ont un id different de l'id supprimé
                    setTaskList(taskList.filter(task => task.idTask !== idTask));
                    setMessage(`Task ${idTask} deleted successfully!`);
                    setError("");
                    console.log("Request successful", response);
                })
                .catch(error => {
                    setMessage("");
                    setError(`Error deleting task: ${error.message}`);
                    console.log("Error request delete", error);
                });
        }
    };

    return (
        <div>
            <List taskList={taskList} onDelete={handleDelete} />
            {message && <p style={{ color: 'green' }}>{message}</p>}
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </div>
    );
}
