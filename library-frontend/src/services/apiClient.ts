import axios, { AxiosRequestConfig } from "axios";

export interface FetchResponse<T> {
  status: string;
  datetime: string;
  next: string | null;
  results: T[];
}

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/api/v1",
});

class APIClient<T> {
  endpoint: string;

  constructor(endpoint: string) {
    this.endpoint = endpoint;
  }

  getAll = (config: AxiosRequestConfig) =>
    axiosInstance
      .get<FetchResponse<T>>(this.endpoint, config)
      .then((res) => res.data);

  getAllFilteredBooks = (id: number | string) =>
    axiosInstance
      .get<FetchResponse<T>>(this.endpoint + "/" + id + "/books")
      .then((res) => res.data);

  registerUser = (obj: T) =>
    axiosInstance.post<T>(this.endpoint, obj).then((res) => res.data);
}

export default APIClient;
