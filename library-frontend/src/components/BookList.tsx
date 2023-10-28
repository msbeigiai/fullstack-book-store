import { SimpleGrid } from "@chakra-ui/react";
import useBooks from "../hooks/useBooks";
import BookCard from "./BookCard";
import useCategoriesFilter from "../hooks/useCategoriesFilter";

interface Props {
  categoryId: number;
}

const BookList = ({ categoryId }: Props) => {
  const { data: books, isLoading, error } = useBooks();

  const { data: fBooks } = useCategoriesFilter(categoryId);

  if (error) return <p>{error.message}</p>;

  if (isLoading) return <p>Loading...</p>;

  if (categoryId === 0) {
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
  }

  return (
    <SimpleGrid
      columns={{ sm: 1, md: 1, lg: 2, xl: 3 }}
      padding="10px"
      spacing={6}
    >
      {fBooks?.results.map((book) => (
        <BookCard key={book.id} book={book} />
      ))}
    </SimpleGrid>
  )





};

export default BookList;
