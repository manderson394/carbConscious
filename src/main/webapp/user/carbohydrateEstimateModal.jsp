<div class="modal fade" id="add-carb-modal" tabindex="-1" role="dialog" aria-labelledby="Add Carb Estimate" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                Add Carbohydrate Estimate
                <button type="button" class="close" data-dismiss="modal" aria-label="close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Enter your estimate of the grams of carbohydrates and your relative blood sugar outcome after then end of your insulin duration time period.</p>
                <form class="form" action="addCarbohydrateEstimate" method="post">
                    <div class="row">
                        <input type="hidden" id="hidden-menu-item-id" name="menuItemIdModal"/>
                    </div>
                    <div class="row">
                        <input type="hidden" id="modal-page-locator" name="sendingPage"/>
                    </div>
                    <div class="row">
                        <input type="hidden" id="modal-search-type" name="modalSearchType"/>
                    </div>
                    <div class="row">
                        <input type="hidden" id="modal-search-input" name="modalSearchInput"/>
                    </div>
                    <div class="row">
                        <input type="hidden" id="modal-api-number-of-results" name="modalApiNumberOfResults"/>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="carb-grams">Grams</label>
                            <input type="text" name="carbGrams" id="carb-grams" class="form-control"/>
                        </div>
                        <div class="col">
                            <label for="outcome">Outcome</label>
                            <select name="outcome" id="outcome" class="form-control">
                                <option value="2">High</option>
                                <option value="1" selected="selected">In Range</option>
                                <option value="0">Low</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class = "col">
                            <button type="submit" class="btn">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
