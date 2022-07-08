import axios from "axios";

export const getData= async()=>{

   let response= await axios.get("http://localhost:8080/backend/Dataloading");
   return response.data.data;
}