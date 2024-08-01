import React from "react";
import trash from "../img/trash.svg";

// Composant pour 
const List = ({ taskList, onDelete }) => {
    return (
        <div>
            {taskList.length > 0 ? (

                <ul>
                    {/* Afficher la liste des taches */}
                        {taskList.map((task) => (
                    <div key={task.idTask} class="listTask">
                        <li><p>{task.taskName}</p></li>
                        <button class="buttonDelete" onClick={() => onDelete(task.idTask)}><img src={trash} alt="Delete"></img></button>
                    </div>
                    ))}

                </ul>
            ) : (
                <p>Aucune tache</p>
            )}
        </div>
    );
};

export default List;
