import axios from "axios";


export interface FetchResponse<T> {
    status: string;
    datetime: string;
    results: T[]
}

const axiosInstance = axios.create({
    baseURL: "http://localhost:8080/api/v1",

});

class APIClient<T> {
    endpoint: string;

    constructor(endpoint: string) {
        this.endpoint = endpoint;
    }

    getAll = () =>
        axiosInstance
            .get<FetchResponse<T>>(this.endpoint)
            .then((res) => res.data)

}

export default APIClient;