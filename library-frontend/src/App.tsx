import { Grid, GridItem } from "@chakra-ui/react";
import BookList from "./components/BookList";
import { Book } from "./hooks/useBooks";
import NavBar from "./components/NavBar";

export interface BookQuery {
  books: Book[];
}

function App() {
  return (
    <>
      <Grid
        templateAreas={{
          base: `"nav" "main"`,
          lg: `"nav nav" "aside main"`,
        }}
        templateColumns={{
          base: "1fr",
          lg: "200px 1fr",
        }}
      >
        <GridItem area="nav">
          <NavBar />
        </GridItem>
        <GridItem area="aside" paddingX={5}>
          Aside
        </GridItem>
        <GridItem area="main">
          <BookList />
        </GridItem>
      </Grid>
    </>
  );
}

export default App;
