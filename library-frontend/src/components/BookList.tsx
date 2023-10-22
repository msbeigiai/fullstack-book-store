import useBooks from "../hooks/useBooks";

const BookList = () => {
  const { data: books, isLoading, error } = useBooks();

  if (error) return <p>{error.message}</p>;

  if (isLoading) return <p>Loading...</p>;

  return (
    <div>
      <ul>
        {books?.map((book) => (
          <li key={book.id}>{book.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;
