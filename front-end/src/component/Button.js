import React from "react";


//  Component submit button
export default function Button(){
    const handleReload = () => {
        window.location.reload();
      };

    return (
        <div class="form">
            <button type="submit" class="button" onClick={handleReload}>Ajouter</button>
        </div>
    );
};