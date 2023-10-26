import { SimpleGrid } from "@chakra-ui/react";
import useBooks from "../hooks/useBooks";
import BookCard from "./BookCard";


const BookList = () => {
  const { data: books, isLoading, error } = useBooks();

  if (error) return <p>{error.message}</p>;

  if (isLoading) return <p>Loading...</p>;

  return (
    <SimpleGrid
      columns={{ sm: 1, md: 1, lg: 2, xl: 3 }}
      padding="10px"
      spacing={6}
    >
      {books?.results.map((book) => (
        <BookCard key={book.id} book={book} />
      ))}
    </SimpleGrid>
  );
};

export default BookList;
