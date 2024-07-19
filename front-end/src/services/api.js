import axios from "axios";

const API_URL = "http://localhost:8080/api";

//  POST request from API
export const createItem=(item) =>{
    return axios.post("http://localhost:8080/api/new",item);
};

//  Get request from API
export const getItem=()=>{
    return axios.get("http://localhost:8080/api/tasks");
};