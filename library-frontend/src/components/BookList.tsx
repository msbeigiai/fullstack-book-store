import { SimpleGrid } from "@chakra-ui/react";
import useBooks from "../hooks/useBooks";
import BookCard from "./BookCard";
import { BookQuery } from "../App";

interface Props {
  bookQuery: BookQuery;
}

const BookList = ({ bookQuery }: Props) => {
  const { data, isLoading, error } = useBooks();

  if (error) return <p>{error.message}</p>;

  if (isLoading) return <p>Loading...</p>;

  return (
    <SimpleGrid
      columns={{ sm: 1, md: 1, lg: 2, xl: 3 }}
      padding="10px"
      spacing={6}
    >
      {data?._embedded.books.map((book) => (
        <BookCard book={book} />
      ))}
    </SimpleGrid>
  );
};

export default BookList;
