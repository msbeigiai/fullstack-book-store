import { SimpleGrid, Spinner } from "@chakra-ui/react";
import React from "react";
import InfiniteScroll from "react-infinite-scroll-component";
import useBooks from "../hooks/useBooks";
import BookCard from "./BookCard";



const BookList = () => {
  const { data, isLoading, error, fetchNextPage, hasNextPage } = useBooks();

  if (error) return <p>{error.message}</p>;

  const fetchBookCount =
    data?.pages.reduce((acc, page) => acc + page.results.length, 0) || 0;


  if (isLoading) return <Spinner />;

  return (
    <InfiniteScroll
      dataLength={fetchBookCount}
      hasMore={!!hasNextPage}
      next={() => fetchNextPage()}
      loader={<Spinner />}
    >
      <SimpleGrid
        columns={{ sm: 1, md: 1, lg: 2, xl: 3 }}
        padding="10px"
        spacing={6}
      >
        {data?.pages.map((page, index) => (
          <React.Fragment key={index}>
            {page.results.map(book => (
              <BookCard key={book.id} book={book} />
            ))}
          </React.Fragment>
        ))}
      </SimpleGrid>
    </InfiniteScroll>
  );

  // if (categoryId === 0) {

  // }

  // return (
  //   <InfiniteScroll
  //     dataLength={fetchBookCount}
  //     hasMore={!!hasNextPage}
  //     next={() => fetchNextPage()}
  //     loader={<Spinner />}
  //   >
  //     <SimpleGrid
  //       columns={{ sm: 1, md: 1, lg: 2, xl: 3 }}
  //       padding="10px"
  //       spacing={6}
  //     >

  //       {
  //         books?.results.map((book) => (
  //           <BookCard key={book.id} book={book} />
  //         ))
  //       }
  //     </SimpleGrid >
  //   </InfiniteScroll>
  // )





};

export default BookList;
