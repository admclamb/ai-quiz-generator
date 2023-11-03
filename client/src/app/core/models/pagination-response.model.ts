export interface PaginationResponseModel<T> {
  content: T[];
  page: number;
  size: number;
  totalPages: number;
  end: boolean;
}
