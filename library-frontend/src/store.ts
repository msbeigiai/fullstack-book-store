import { create } from "zustand";

interface BookQuery {
    categoryId?: number;
}

interface BookQueryStore {
    bookQuery: BookQuery;
    setCategoryId: (categoryId: number) => void
}

const useBookQueryStore = create<BookQueryStore>((set) => ({
    bookQuery: {},
    setCategoryId: (categoryId) => set((store) =>
        ({ bookQuery: { ...store.bookQuery, categoryId } })),
}));

export default useBookQueryStore;