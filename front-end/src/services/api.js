import axios from "axios";

const API_URL = "http://localhost:8080/api";

export const createItem=(item) =>{
    return axios.post("http://localhost:8080/api/new",item);
};

// export const getItem=()=>{
//     return axios.get("${API_URL}/");
// };