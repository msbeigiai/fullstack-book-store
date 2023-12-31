import { useInfiniteQuery } from "@tanstack/react-query";
import APIClient, { FetchResponse } from "../services/apiClient";
import { Book } from "../entities/Book";
import useBookQueryStore from "../store";

const apiClient = new APIClient<Book>("/books");

const useBooks = () => {
  const bookQuery = useBookQueryStore(s => s.bookQuery)
  return useInfiniteQuery<FetchResponse<Book>, Error>({
    queryKey: ["books", bookQuery],
    queryFn: ({ pageParam = 0 }) =>
      apiClient.getAll({
        params: {
          category: bookQuery.categoryId,
          search: bookQuery.searchText,
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
