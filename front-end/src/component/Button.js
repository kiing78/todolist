import React from "react";

//  Component submit button
export default function Button(){
    const handleReload = () => {
        window.location.reload();
      };

    return (
        <div>
            <button type="submit"  onClick={handleReload}>Ajouter</button>
        </div>
    );
};