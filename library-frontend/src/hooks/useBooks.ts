import { useQuery } from "@tanstack/react-query";
import axios from "axios";

export interface Book {
  id: number;
  title: string;
  author: string;
  description: string;
  copies: number;
  copiesAvailable: number;
  category: string;
  image: string;
}

interface FetchResponse<T> {
  count: number;
  _embedded: { books: T[] };
}

const useBooks = () => {
  return useQuery({
    queryKey: ["books"],
    queryFn: () =>
      axios
        .get<FetchResponse<Book>>("http://localhost:8080/api/v1/books")
        .then((res) => res.data),
    staleTime: 10 * 1000,
  });
};

export default useBooks;
