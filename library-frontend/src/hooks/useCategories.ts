import { useQuery } from "@tanstack/react-query";
import { Category } from "../entities/Category";
import APIClient, { FetchResponse } from "../services/apiClient";

const apiClient = new APIClient<Category>("/categories")

const useCategories = () =>
    useQuery<FetchResponse<Category>, Error>({
        queryKey: ["categories"],
        queryFn: apiClient.getAll
    });

export default useCategories;
