import { useInfiniteQuery } from "@tanstack/react-query";
import APIClient, { FetchResponse } from "../services/apiClient";
import { Book } from "../entities/Book";

const apiClient = new APIClient<Book>("/books");

const useBooks = () => {
  return useInfiniteQuery<FetchResponse<Book>, Error>({
    queryKey: ["books"],
    queryFn: ({ pageParam = 0 }) =>
      apiClient.getAll({
        params: {
          page: pageParam,
        },
      }),
    getNextPageParam: (lastPage, allPages) => {
      console.log(lastPage.next)
      return lastPage.next ? allPages.length + 1 : undefined;
    },
    staleTime: 60 * 60 * 24 * 1000,
  });
};


export default useBooks;
