import { SimpleGrid } from "@chakra-ui/react";
import useBooks from "../hooks/useBooks";
import BookCard from "./BookCard";

const BookList = () => {
  const { data: books, isLoading, error } = useBooks();

  if (error) return <p>{error.message}</p>;

  if (isLoading) return <p>Loading...</p>;

  return (
    <SimpleGrid
      columns={{ sm: 1, md: 2, lg: 3, xl: 4 }}
      padding="10px"
      spacing={6}
    >
      {books?.map((book) => (
        <BookCard book={book} />
      ))}
    </SimpleGrid>
  );
};

export default BookList;
