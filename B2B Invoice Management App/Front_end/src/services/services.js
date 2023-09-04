import axios from "axios";
// import { SERVER_URL, ROLL_NUMBER } from "../utils/constants";
const SERVER_URL = "http://localhost:8080/HRC62339WK"
export const getData = async () => {
  let response = await axios.get(`${SERVER_URL}/Fetch`);
  console.log(response.data.invoiceData);
  // return response.data.invoiceData;
  let data = response.data.invoiceData;
  data.map((invoice, index) => ({ ...invoice, id: index }));
  return data;
};