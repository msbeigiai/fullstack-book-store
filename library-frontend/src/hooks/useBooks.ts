import { useQuery } from "@tanstack/react-query";
import { Book } from "../entities/Book";
import APIClient, { FetchResponse } from "../services/apiClient";

const apiClient = new APIClient<Book>("/books")

const useBooks = () =>
  useQuery<FetchResponse<Book>, Error>({
    queryKey: ["books"],
    queryFn: apiClient.getAll
  });

export default useBooks;
