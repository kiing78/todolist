import React from "react";

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