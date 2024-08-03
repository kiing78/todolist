import React from "react";

// Composant pour 
const List = ({ taskList, onDelete }) => {
    return (
        <div>
            {taskList.length > 0 ? (

                <ul>
                    {/* Afficher la liste des taches */}
                        {taskList.map((task) => (
                    <div key={task.idTask}>
                        <li><p>{task.taskName}</p></li>
                        <button onClick={() => onDelete(task.idTask)}>Delete</button>
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
