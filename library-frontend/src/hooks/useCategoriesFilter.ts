import { useQuery } from "@tanstack/react-query";
import { Book } from "../entities/Book";
import APIClient from "../services/apiClient";

const apiClient = new APIClient<Book>("/categories")

const useCategoriesFilter = (bookId: number) =>
    useQuery({
        queryKey: ["books", bookId],
        queryFn: () => apiClient.getAllFilteredBooks(bookId)
    })

export default useCategoriesFilter;