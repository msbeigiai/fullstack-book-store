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

const useBooks = () => {
  const fetchBooks = () =>
    axios
      .get<Book[]>("http://localhost:8080/api/v1/books")
      .then((res) => res.data["_embedded"]["books"]);

  return useQuery<Book[], Error>({
    queryKey: ["books"],
    queryFn: fetchBooks,
    staleTime: 10 * 1000,
  });
};

export default useBooks;
